package practice;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class AnimalShelter {
    Map<AnimalType, LinkedList<Animal>> animalTypeLinkedListMap;

    public AnimalShelter() {
        animalTypeLinkedListMap = new HashMap<>();
    }

    public void enqueue(Animal animal) {
        Date arrivalTime = new Date();
        animal.setTimestamp(arrivalTime);
        animalTypeLinkedListMap.getOrDefault(animal.getAnimalType(), new LinkedList<>()).addLast(animal);
    }

    public Animal dequeueAnimal(AnimalType animalType) {
        return animalTypeLinkedListMap.get(animalType).poll();
    }

    public Animal dequeueAny() {
        Animal oldest = null;
        for (Map.Entry<AnimalType, LinkedList<Animal>> entry : animalTypeLinkedListMap.entrySet()) {
            Animal currentAnimal = entry.getValue().peek();
            if (oldest == null || currentAnimal.isOlderThan(oldest)) {
                oldest = currentAnimal;
            }
        }
        //dequeue the oldest
        return animalTypeLinkedListMap.get(oldest.getAnimalType()).poll();
    }
}

enum AnimalType {
    DOG, CAT
}

class Animal {
    private AnimalType animalType;
    private Date timestamp;

    public boolean isOlderThan(Animal animal) {
        return timestamp.before(animal.getTimestamp());
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}

