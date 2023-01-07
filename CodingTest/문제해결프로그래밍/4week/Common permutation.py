# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
import itertools
	
def check(n_set,word,num):
	for n in range(num+1):
		tmp = list(itertools.permutations(word,n))
		for j in tmp:
			string = "".join(j)
			n_set.add(string)

try:
	while True:
		a = input()
		b = input()
		
		if a == b:
			print(a)
			continue

		a_set = set()
		b_set = set()
		
		num = min(len(a),len(b))		
		check(a_set,a,num)
		check(b_set,b,num)
		
		total_set = list(a_set & b_set)
		total_set.sort(reverse=True)
		total_set.sort(key = lambda i : len(i))
		print(total_set[-1])
			
except:
	pass