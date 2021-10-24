import pyppeteer

with open('flag.txt', 'r') as f:
    flag = f.read()


async def visit(url):
    url = 'http://0.0.0.0:3010/static/%s.html' % url
    browser = await pyppeteer.launch(handleSIGINT=False,
                                     handleSIGTERM=False,
                                     handleSIGHUP=False)
    page = await browser.newPage()
    await page.setCookie({'url': url, 'name': 'flag', 'value': flag})
    await page.goto(url)