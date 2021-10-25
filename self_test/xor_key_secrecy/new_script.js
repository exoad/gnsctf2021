let input = `CQEHMDElCRAHXTAHQAYWAFYrBVwNRjoTHlAJ`;

// Convert base64-encoded string back to the original bytes
input = atob(input);

function getHammingDistance(a, b) {
  let val = 0;
  a.split('').forEach((char, i) => {
    let decA = getDec(char);
    let decB = getDec(b[i]);
    while (decA) {
      if (decA & 1 !== decB & 1) {
        val++;
      }
      decA = decA >> 1;
      decB = decB >> 1;
    }
  });
  return val;
}

function getDec(c) {
  return c.charCodeAt(0);
}

function getKeySize(input) {
  let size = 2;
  let bestScore = 1000000;
  let keySize = 1000000;
  while (size <= 40) {
    // Instead of using two samples, we will use max samples
    const chunks = createChunks(input, size);
    const collection = [];
    for (let i = 0; i < chunks.length; i++) {
      const chunk = chunks[i];
      if (i % 2 === 0) {
        collection.push([]);
      }
      collection[collection.length - 1].push(chunk);
    }
    // Filter out uncomparable chunks
    const comparisions = collection.filter(pair => pair.length === 2 && pair[0].length === pair[1].length);
    let score = 0;
    // Calculate hamming distance
    comparisions.forEach(pair => {
      const distance = getHammingDistance(pair[0], pair[1]);
      score += distance;
    });
    // We don't have to normalize as recommended because normalization happens due to the large sample size and the comparisions array
    if (score < bestScore) {
      bestScore = score;
      keySize = size;
    }
    size++;
  }
  return keySize;
}

function createChunks(str, size) {
  let i = 0;
  const chunks = [];
  while (i < str.length) {
    const start = i;
    const end = i + size;
    const chunk = str.substring(start, end);
    chunks.push(chunk);
    i = i + size;
  }
  return chunks;
}

// 1. It starts with knowing the keysize
const keySize = getKeySize(input);

// 2. Divide the input into keySize sized chunks
const chunks = createChunks(input, keySize);
const totalChunks = chunks.length;

// 3. Rotate the keysize chunk matrix to the right - characters in each row is XOR'd with the same character from the key
const transposed = [];
for (let i = 0; i < totalChunks; i++) {
  transposed.push([]);
}

let tcounter = 0;
input.split('').forEach(char => {
  if (tcounter === keySize) {
    tcounter = 0;
  }
  transposed[tcounter].push(char);
  tcounter++;
});

function getKey(input) {
  const res = {};
  let candidateKey = '';
  let highestScore = 0;
  const freq = [' ', 'e', 't', 'a', 'o', 'i', 'n', 's', 'h', 'r', 'd', 'l', 'u'];
  const keys = [];

  for (let i = 0; i <= 255; i++) {
    keys.push(String.fromCharCode(i));
  }

  keys.forEach(key => {
    let output = '';
    let cursor = 0;
    while (cursor < input.length) {
      let charCode = input.slice(cursor, cursor + 1).charCodeAt(0);
      let xor = charCode ^ key.charCodeAt(0);
      output += String.fromCharCode(xor);
      cursor += 2;
    }
    let score = 0;
    freq.forEach((key, i) => {
      const re = new RegExp(key, 'g');
      const matches = output.toLowerCase().match(re);
      if (matches) {
        score += matches.length * (12 - i);
      }
    });
    if (score > highestScore) {
      highestScore = score;
      candidateKey = key;
      res[key] = output;
    }
  });

  return {
    key: candidateKey,
    message: res[candidateKey],
    score: highestScore
  }
}

let key = '';
let message = '';

// 4. Crack the single-character XOR key for each row - concatenating them yields the whole key
transposed.forEach(lines => {
  const joined = lines.join('');
  const cracked = getKey(joined);
  if (cracked.score) {
    key += cracked.key;
    message += cracked.message;
  }
});

console.log(`KEY: ${key}`);
console.log('');

function toAsciiString(string) {
  return string.split('').map(char => char.charCodeAt(0)).join('');
}

function xorDecrypt(input, key) {
  let res = '';
  const keyCharsArray = [];

  key.split('').forEach(keyChar => {
    const asciiKeyChar = toAsciiString(keyChar);
    keyCharsArray.push(asciiKeyChar);
  });

  let keyCharsIndex = 0;

  input.split('').forEach(inputChar => {
    const asciiInputChar = toAsciiString(inputChar);
    const xored = asciiInputChar ^ keyCharsArray[keyCharsIndex];

    res += String.fromCharCode(xored);

    if (keyCharsIndex == key.length) keyCharsIndex = 0;
    else keyCharsIndex++;
  });

  return res;
}

// 4. Crack the keySize sized chunks using the key - concatenating them yields the unencrypted input
let decrypted = '';
chunks.forEach(sub => {
  decrypted += xorDecrypt(sub, key);
});

console.log(decrypted);