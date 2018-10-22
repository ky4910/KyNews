# -*- coding: utf-8 -*-

import requests
from bs4 import BeautifulSoup
#import pymssql

#推荐 https://new.qq.com/ch/rec/
#体育 https://new.qq.com/ch/sports/
#财经 https://new.qq.com/ch/finance/
#军事 https://new.qq.com/ch/milite/
#科技 https://new.qq.com/ch/tech/
#娱乐 https://new.qq.com/ch/ent/
#汽车 https://new.qq.com/ch/auto/

url = "https://news.qq.com/"
#请求腾讯新闻URL，获取text文本
wbdata = requests.get(url).text
soup = BeautifulSoup(wbdata, 'lxml')

#分别获取要问，财经，娱乐新闻信息
major_titles = soup.select("div.item.major > div.Q-tpList > div.Q-tpWrap > div.text > em.f14 > a.linkto")
finance_titles = soup.select("div.item.finance > div.Q-tpList > div.Q-tpWrap > div.text > em.f14 > a.linkto")
ent_titles = soup.select("div.item.ent > div.Q-tpList > div.Q-tpWrap > div.text > em.f14 > a.linkto")

#定义列表数组
news_titles = {'major':major_titles, 'finance':finance_titles, 'entertainment':ent_titles}


for key, value in news_titles.items():
	print("the index" + key) 
	for n in value:
		title = n.get_text()
		link = n.get("href")
		data = {'标题':title, '链接':link}
		try:
			print(data)
		except UnicodeEncodeError:
			print("cannot print this string!")
	print('')

print ('connecting to MySQL Server...')


