
# Code from Chapter 4 of Machine Learning: An Algorithmic Perspective (2nd Edition)
# by Stephen Marsland (http://stephenmonika.net)

# You are free to use, change, or redistribute the code in any way you wish for
# non-commercial purposes, but please maintain the name of the original author.
# This code comes with no warranty of any kind.

# Stephen Marsland, 2008, 2014

# The sinewave-regression example from the book

import matplotlib.pyplot as plt
#import pylab as pl
import numpy as np
import pprint

# Clear the figure or the axes, as necessary (if there were prior plots).
plt.clf()
plt.cla()

# Set up the data
x = np.linspace(0,1,40).reshape((40,1))
t = np.sin(2*np.pi*x) + np.cos(4*np.pi*x) + np.random.randn(40).reshape((40,1))*0.2
x = (x-0.5)*2

# Split into training, testing, and validation sets
train = x[0::2,:]
test = x[1::4,:]
valid = x[3::4,:]
traintarget = t[0::2,:]
testtarget = t[1::4,:]
validtarget = t[3::4,:]

# Plot the data (to see how they really look):
plt.plot(x,t,'o')
plt.xlabel('x')
plt.ylabel('t')

# Just to demonstrate it, let's select a tight layout...
plt.tight_layout()

# ... and change the display size:
fig = plt.gcf()
fig.set_size_inches(6, 2)
plt.show()

# training with a small BPNN
from MVLP import mlp
net = mlp(train,traintarget,3,outtype='linear')
net.mlptrain(train,traintarget,0.25,101)

# using early stopping
net.earlystopping(train,traintarget,valid,validtarget,0.25)

#printing the results
test = np.concatenate((test,-np.ones((np.shape(test)[0],1))),axis=1)
outputs = net.mlpfwd(test)
plt.plot(test,outputs)
plt.show()

# trying different network sizes
#count = 0
#out = np.zeros((10,7))
#for nnodes in [1,2,3,5,10,25,50]:
#    for i in range(10):
#        net = mlp(train,traintarget,nnodes,outtype='linear')
#        out[i,count] = net.earlystopping(train,traintarget,valid,validtarget,0.25)
#    count += 1
    
#test = np.concatenate((test,-np.ones((np.shape(test)[0],1))),axis=1)
#outputs = net.mlpfwd(test)

#print("The sum of squared errors is: ", 0.5*sum((outputs-testtarget)**2))

#print("The outputs are: ")
#pp = pprint.PrettyPrinter(indent=10)
#pp.pprint(out)
#print("output means: ", out.mean(axis=0))
#print("output variances: ", out.var(axis=0))
#print("output maxima: ", out.max(axis=0))
#print("output minima: ", out.min(axis=0))
