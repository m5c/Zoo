package eu.kartoffelquadrat.zoo;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Principal class of the Zoo, offering all relevant public functionality. Access is exposed via Spring request mappings.
 *
 * @author Maximilian Schiedermeier
 */
@RestController
public class Zoo {

    // private fields for indexed animals and opening hours.
    private final Map<String, Animal> animals;
    private final OpeningHours openingHours;

    /**
     * Public constructor, populates the zoo. Invoked by Spring once, to create a REST controller instance.
     */
    public Zoo() {
        openingHours = new OpeningHours();
        animals = new LinkedHashMap<>();
        addAnimal("Charly", new Animal("Chimpanzee", 10, "Bananas"));
        addAnimal("Nemo", new Animal("Clownfish", 4, "Plankton"));
        addAnimal("Dumbo", new Animal("Elephant", 13, "Peanuts"));
    }

    /**
     * Returns a list with all animal names.
     *
     * @return Collection with the names of all indexed animals.
     */
    @GetMapping("zoo/animals")
    public Collection<String> getAllAnimalNames() {
        return animals.keySet();
    }

    /**
     * Getter to look up details on one specific animal, identified by name.
     *
     * @param name as the animals name.
     * @return the animal object associated to this name.
     */
    @GetMapping("zoo/animals/{animalname}")
    public Animal getAnimalDetails(@PathVariable("animalname") String name) {
        return animals.get(name);
    }

    /**
     * Setter to add a new animal to the zoo.
     *
     * @param name   as the name of the animal to index.
     * @param animal as the characteristics of the animal to add.
     */
    @PutMapping("zoo/animals/{animalname}")
    public void addAnimal(@PathVariable("animalname") String name, @RequestBody Animal animal) {
        animals.put(name, animal);
    }

    /**
     * Getter to retrieve the zoo opening hours.
     *
     * @return the zoo opening hours.
     */
    @GetMapping("zoo/openinghours")
    public OpeningHours getOpeningHours() {
        return openingHours;
    }

}
