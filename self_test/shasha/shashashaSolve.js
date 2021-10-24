// Jojo: SHA256 is unbreakable!
// this is not the challenge! Don't waste your time trying to reverse sha256

/**
 * @param {string | any[]} r
 */
function SHA256(r) {
  var n = 8,
    t = 0;
  /**
   * @param {number} r
   * @param {number} n
   */
  function e(r, n) {
    var t = (65535 & r) + (65535 & n);
    return (((r >> 16) + (n >> 16) + (t >> 16)) << 16) | (65535 & t);
  }
  /**
   * @param {number} r
   * @param {number} n
   */
  function o(r, n) {
    return (r >>> n) | (r << (32 - n));
  }
  /**
   * @param {number} r
   * @param {number} n
   */
  function u(r, n) {
    return r >>> n;
  }
  /**
   * @param {number} r
   * @param {number} n
   * @param {number} t
   */
  function a(r, n, t) {
    return (r & n) ^ (~r & t);
  }
  /**
   * @param {number} r
   * @param {number} n
   * @param {number} t
   */
  function f(r, n, t) {
    return (r & n) ^ (r & t) ^ (n & t);
  }
  /**
   * @param {number} r
   */
  function c(r) {
    return o(r, 2) ^ o(r, 13) ^ o(r, 22);
  }
  /**
   * @param {number} r
   */
  function i(r) {
    return o(r, 6) ^ o(r, 11) ^ o(r, 25);
  }
  /**
   * @param {any} r
   */
  function h(r) {
    return o(r, 7) ^ o(r, 18) ^ u(r, 3);
  }
  return (function (r) {
    for (
      var n = t ? "0123456789ABCDEF" : "0123456789abcdef", e = "", o = 0;
      o < 4 * r.length;
      o++
    )
      e +=
        n.charAt((r[o >> 2] >> (8 * (3 - (o % 4)) + 4)) & 15) +
        n.charAt((r[o >> 2] >> (8 * (3 - (o % 4)))) & 15);
    return e;
  })(
    (function (r, n) {
      var t,
        C,
        g,
        A,
        d,
        v,
        S,
        l,
        m,
        y,
        w,
        b = new Array(
          1116352408,
          1899447441,
          3049323471,
          3921009573,
          961987163,
          1508970993,
          2453635748,
          2870763221,
          3624381080,
          310598401,
          607225278,
          1426881987,
          1925078388,
          2162078206,
          2614888103,
          3248222580,
          3835390401,
          4022224774,
          264347078,
          604807628,
          770255983,
          1249150122,
          1555081692,
          1996064986,
          2554220882,
          2821834349,
          2952996808,
          3210313671,
          3336571891,
          3584528711,
          113926993,
          338241895,
          666307205,
          773529912,
          1294757372,
          1396182291,
          1695183700,
          1986661051,
          2177026350,
          2456956037,
          2730485921,
          2820302411,
          3259730800,
          3345764771,
          3516065817,
          3600352804,
          4094571909,
          275423344,
          430227734,
          506948616,
          659060556,
          883997877,
          958139571,
          1322822218,
          1537002063,
          1747873779,
          1955562222,
          2024104815,
          2227730452,
          2361852424,
          2428436474,
          2756734187,
          3204031479,
          3329325298
        ),
        p = new Array(
          1779033703,
          3144134277,
          1013904242,
          2773480762,
          1359893119,
          2600822924,
          528734635,
          1541459225
        ),
        B = new Array(64);
      (r[n >> 5] |= 128 << (24 - (n % 32))),
        (r[15 + (((n + 64) >> 9) << 4)] = n);
      for (var D = 0; D < r.length; D += 16) {
        (t = p[0]),
          (C = p[1]),
          (g = p[2]),
          (A = p[3]),
          (d = p[4]),
          (v = p[5]),
          (S = p[6]),
          (l = p[7]);
        for (var E = 0; E < 64; E++)
          (B[E] =
            E < 16
              ? r[E + D]
              : e(
                  e(
                    e(o((w = B[E - 2]), 17) ^ o(w, 19) ^ u(w, 10), B[E - 7]),
                    h(B[E - 15])
                  ),
                  B[E - 16]
                )),
            (m = e(e(e(e(l, i(d)), a(d, v, S)), b[E]), B[E])),
            (y = e(c(t), f(t, C, g))),
            (l = S),
            (S = v),
            (v = d),
            (d = e(A, m)),
            (A = g),
            (g = C),
            (C = t),
            (t = e(m, y));
        (p[0] = e(t, p[0])),
          (p[1] = e(C, p[1])),
          (p[2] = e(g, p[2])),
          (p[3] = e(A, p[3])),
          (p[4] = e(d, p[4])),
          (p[5] = e(v, p[5])),
          (p[6] = e(S, p[6])),
          (p[7] = e(l, p[7]));
      }
      return p;
    })(
      (function (r) {
        for (var t = Array(), e = (1 << n) - 1, o = 0; o < r.length * n; o += n)
          t[o >> 5] |= (r.charCodeAt(o / n) & e) << (24 - (o % 32));
        return t;
      })(
        (r = (function (r) {
          // @ts-ignore
          r = r.replace(/\r\n/g, "\n");
          for (var n = "", t = 0; t < r.length; t++) {
            // @ts-ignore
            var e = r.charCodeAt(t);
            e < 128
              ? (n += String.fromCharCode(e))
              : e > 127 && e < 2048
              ? ((n += String.fromCharCode((e >> 6) | 192)),
                (n += String.fromCharCode((63 & e) | 128)))
              : ((n += String.fromCharCode((e >> 12) | 224)),
                (n += String.fromCharCode(((e >> 6) & 63) | 128)),
                (n += String.fromCharCode((63 & e) | 128)));
          }
          return n;
        })(r))
      ),
      r.length * n
    )
  );
}

// sha256 is unbreakable, so if I throw it around everywhere, it should be super secure, right?



const fs = require('fs');

const flag =
  "gnsCTF{f67ab10ad4e4c53121b6a5fe4da9c10ddee905b978d3788d2723d7bfacbe28a972dfcfb0c470ac255cde83fb8fe38de8a128188e03ea5ba5b2a93adbea1062fa559aead08264d5795d3909718cdd05abd49572e84fe55590eef31a88a08fdffd333e0a1e27815d0ceee55c473fe3dc93d56c63e3bee2b3b4aee8eed6d70191a3d2e2adf7177b7a8afddbc12d1634cf23ea1a71020f6a1308070a16400fb68fde8c2574892063f995fdf756bce07f46c1a5193e54cd52837ed91e32008ccf41aca9f51566bd6705f7ea6ad54bb9deb449f795582d6529a0e22207b8981233ec583f39d5c348e5b79d06e842c114e6cc571583bbf44e4b0ebfda1a01ec05745d43559aead08264d5795d3909718cdd05abd49572e84fe55590eef31a88a08fdffd6b23c0d5f35d1b11f9b683f0b0a617355deb11277d91ae091d399c655b87940de632b7095b0bf32c260fa4c539e9fd7b852d0de454e9be26f24d0d6f91d069d3a9f51566bd6705f7ea6ad54bb9deb449f795582d6529a0e22207b8981233ec583f39d5c348e5b79d06e842c114e6cc571583bbf44e4b0ebfda1a01ec05745d43}";

const characters = flag.split("");
const hashes = characters.map((v) => SHA256(v));

console.log(hashes.join(""));

function hex_to_ascii(str1) {
  var hex = str1.toString();
  var str = "";
  for (var n = 0; n < hex.length; n += 2) {
    str += String.fromCharCode(parseInt(hex.substr(n, 2), 16));
  }
  return str;
}

try {
  fs.writeFileSync("self_test/shasha/hash1.txt", hex_to_ascii(hashes.join("")));
  fs.writeFileSync("self_test/shasha/hash2.txt", hashes.join(""));
  //file written successfully
} catch (err) {
  console.error(err);
}

