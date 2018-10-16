# -*- coding: utf-8 -*-
import os
from PIL import Image
from PIL import ImageFilter

input_source = "E:/workspace/img/ex/"
output_source = "E:/workspace/img/exresult/"

def convert(picture_name):
	imgInput_FileName = input_source + picture_name
	imgOutput_FileName = output_source + picture_name
	
	img = Image.open(imgInput_FileName)
 
	# 模式L”为灰色图像，它的每个像素用8个bit表示，0表示黑，255表示白，其他数字表示不同的灰度。
	#Img = img.convert('L')
	# 轮廓
	#Img = img.filter(ImageFilter.CONTOUR)
	Img = img.filter(ImageFilter.CONTOUR).convert('L')
	# 保存
	#Img.save(imgOutput_FileName)
	 
	# 自定义灰度界限，大于这个值为黑色，小于这个值为白色
	threshold = 240
	 
	table = []
	for i in range(256):
		if i < threshold:
			table.append(0)
		else:
			table.append(1)
	 
	# 图片二值化
	photo = Img.point(table, '1')
	photo.save(imgOutput_FileName)
		
ImageList = [] #建立空的List

#循环读取文件名
for filename in os.listdir(r"" + input_source):
	ImageList.append(filename)  #将文件名添加到ImageList

for x in ImageList: #循环读取ImageList中的文件名，将其进行卡通化处理
	print("正在卡通化" + x)
	convert(x)