package lectures;


import static org.assertj.core.api.Assertions.assertThat;
import static sun.tools.jstat.Alignment.keySet;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture5_filter {

  final Predicate<Car> carPredicate = car -> car.getPrice() < 20000;

  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();

    List<Car> carsFiltered = cars.stream()
            .filter(carPredicate)
            .collect(Collectors.toList());

    carsFiltered.forEach(System.out::println);
    System.out.println(carsFiltered.size());
  }

  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();

    Function<Person, PersonDTO> personPersonDTOFunction = person -> new PersonDTO(person.getId(), person.getFirstName(), person.getAge());


    List<PersonDTO> dtos = people.stream()
            .map(personPersonDTOFunction)
            .collect(Collectors.toList());

    List<PersonDTO> dtos2 = people.stream()
            .map(PersonDTO::map)
            .collect(Collectors.toList());

    dtos.forEach(System.out::println);
    assertThat(dtos).hasSize(1000);
    System.out.println(dtos.size());
  }

  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices

    ImmutableList<Car> cars = MockData.getCars();

    double average = cars.stream()
            .mapToDouble(Car::getPrice)
            .average()
            .orElse(0);

    System.out.println(average);
  }



}



