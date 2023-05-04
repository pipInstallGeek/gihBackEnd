import matplotlib.pyplot as plt
import numpy as np
import sys
import os

def nextStep(yourCurrentState, nbreOfSteps):
    P = np.array([  [0.96, 0.03, 0.009, 0.0009, 0.0001],
                    [0,    0.95, 0.04, 0.008, 0.002],
                    [0,       0,   0.94, 0.055,  0.005],
                    [0,       0,  0,    0.92,   0.08],
                    [0, 0,  0,    0,      1]])
    piInititale = np.zeros(5)
    piInititale[yourCurrentState] = 1
    b = np.linalg.matrix_power(P, nbreOfSteps)
    pi = piInititale@b
    return pi

def allBed( ):
    cwd = os.getcwd()
    cwd = cwd +"\Python"
    bedListString= sys.argv[1]
    iterationsString = sys.argv[2]

    bedList = list(map(int, bedListString.split("$")))
    iterations = int(iterationsString)
    proba = np.zeros(5)

    for i in bedList:
        proba +=nextStep(i, iterations)

    proba /= len(bedList)
    states = ['Brand New','Good ', 'Fair ', 'Poor ', 'Defective ']
    title = f'Future State Of The Beds After {iterations} week(s)'
    plt.pie(proba, labels=states, autopct='%1.1f%%')
    plt.title(title)
    plt.axis('equal')
    plt.gca().set_facecolor('#FFFFFF')
    plt.savefig("predictionStateOfBeds.png")


allBed()

