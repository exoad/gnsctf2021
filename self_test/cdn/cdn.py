import random, string, bot
from flask import Flask, request, redirect, render_template

ALLOWED_EXTENSIONS = {'png', 'jpg', 'jpeg'} # allowed file types

app = Flask(__name__)
app.config['MAX_CONTENT_LENGTH'] = 16 * 1000 * 1000 # 16 megabytes

def allowed_file(filename):
    return '.' in filename and filename.rsplit('.', 1)[1].lower() in ALLOWED_EXTENSIONS

@app.route('/', methods=['GET', 'POST'])
def upload_file():
    if request.method == 'POST':
        if 'file' not in request.files:
            return redirect(request.url)
        
        file = request.files['file']
        fn = file.filename

        if fn == '':
            return redirect(request.url)
        
        if file and allowed_file(fn):
            random_id = ''.join([random.choice(string.ascii_letters + string.digits) for n in range(32)]) # makes the id
            file.save('static/' + fn)

            data = '<img src="%s"/>' % fn
            with open('static/%s.html' % random_id, 'w') as f:
                f.write(data) # append the image data to the upload html

            return render_template('upload.html', id = random_id)

    return render_template("upload.html")

@app.route('/report', methods=['GET', 'POST'])
async def report_file():
    if request.method == "POST":
        id = request.form.get("id")
        if not id:
            return redirect(request.url)

        if not id.isalnum():
            return redirect(request.url)

        await bot.visit(id)
        return render_template('report.html', reported=True)
        
    return render_template('report.html')

app.run(host='0.0.0.0', port=3010)