#The input file structure is as follows:
#The first line will contain the size of the knapsack
#The second line will contain the maximum number of generations you want 
#The third line will contain the sizes of the items in a single line. For example: 5, 3, 9, 8, 1, 2, 4, 7

import random
import sys

#Defaults
geneSize = [5, 3, 9, 8, 1, 2, 4, 7]
population = []
fitness = []
desiredFitness = 0
size = 25
sizeOfChromosome = []
fileName = str(sys.argv[1])
if len(fileName) == 0:
	print ("File name not provided.")
	print ("Run the program as python3 HW3.py <fileName>")
	sys.exit()
inFile = open(fileName, 'r')
size = int(inFile.readline())
maxGenerations = int(inFile.readline())
geneSize = inFile.readline().split(',')

for i in range(len(geneSize)):
	geneSize[i] = int(geneSize[i])

def initializePopulation():

        for i in range(5):
                tempList = []
                for j in range(8):
                        temp = random.randint(1, 8)
                        tempList.append(temp % 2)
                population.append(tempList)

def calculateFitness(knapsackSize, individual):
        fitnessValue = 0
        for j in range(8):
                fitnessValue +=  (individual[j] * geneSize[j])
        return (knapsackSize - fitnessValue)**2

def calculateSize(individual):
	sum = 0
	for i in range(len(individual)):
		sum += individual[i] * geneSize[i]
	return sum

def selectParentRandom(population):
        temp = random.randint(0,len(population)-1)
        temp1 = random.randint(0,len(population)-1)
        temp2 = random.randint(0,len(population)-1)
        tempFitness = fitness[temp]
        selectedParentIndex = temp
        if fitness[temp1] < tempFitness:
                tempFitness = fitness[temp1]
                selectedParentIndex = temp1
        if fitness[temp2] < tempFitness:
                tempFitness = fitness[temp2]
                selectedParentIndex = temp2
        return selectedParentIndex

def crossover(parentOne, parentTwo):
        child = population[parentOne].copy()
        for i in range(4):
                temp = random.randint(0, 7)
                child[temp] = population[parentTwo][temp]
        return child

def mutation(i):
        mutationPoint = 0
        mutationPoint = random.randint(0,7)
        if population[i][mutationPoint] == 0:
                population[i][mutationPoint] = 1
        else:
                population[i][mutationPoint] = 0

def findGivenFitness(inFitness):
        found = False
        foundIndex = -1
        i = 0
        while i < (len(population) - 1) and found == False:
                if(fitness[i] == inFitness):                        
                        found = True
                        foundIndex = i
                i +=1

        return foundIndex

def findBestSize(population):
	tempSize = size
	differenceInSize = size
	bestSizeIndex = 0
	for i in range(len(population)):
		if size - sizeOfChromosome[i] >= 0 and (size - sizeOfChromosome[i]) < differenceInSize:
			differenceInSize = size - sizeOfChromosome[i]
			bestSizeIndex = i
	return bestSizeIndex

initializePopulation()

for i in range(len(population)):
        tempFitness = calculateFitness (size, population[i])
        fitness.append (tempFitness)
        sizeOfChromosome.append(calculateSize(population[i]))

previousFitness = 0
done = False
iteration = 0
while not done and iteration < maxGenerations:
        bestSizeIndex = findBestSize(population)
        print("Generation: " + str(iteration) + " Fitness: " + str(min(fitness)) + " Chromosome with best size: " + str(population[bestSizeIndex]) + " Size: " + str(sizeOfChromosome[bestSizeIndex]))
        populationSize = len(population)
        
        found = False
        for i in range(populationSize):
                parentOneIndex = selectParentRandom(population)
                parentTwoIndex = selectParentRandom(population)
                nextGenChild = crossover(parentOneIndex, parentTwoIndex)
                population.append(nextGenChild)
                mutationChoice = random.randint(1, 10000)
                if mutationChoice % 30 == 0:
                        mutation(len(population)-1)
                tempFitness = calculateFitness(size, nextGenChild)
                fitness.append(tempFitness)
                sizeOfChromosome.append(calculateSize(nextGenChild))
                found = False
        findFitness = findGivenFitness(desiredFitness)
        if(findFitness > -1 or found):
                print("Chromosome with matching size found: "  + str(population[findFitness]) + " Size: " + str(sizeOfChromosome[findFitness]) + " Desired Size: " + str(size))
                done = True
        else:
                iteration += 1

if iteration == maxGenerations:
        print("Not Found after " + str(maxGenerations)  + " Generations")
