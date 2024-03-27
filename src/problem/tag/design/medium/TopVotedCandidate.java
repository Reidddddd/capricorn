package problem.tag.design.medium;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * 911. Online Election
 * <p></p>
 * https://leetcode.com/problems/online-election/
 * <p></p>
 */
public class TopVotedCandidate {

  private TreeMap<Integer, Person> timeTopVote;
  private HashMap<Integer, Person> personVotes;

  public TopVotedCandidate(int[] persons, int[] times) {
    timeTopVote = new TreeMap<>();
    personVotes = new HashMap<>();

    int max = Integer.MIN_VALUE;
    for (int i = 0; i < persons.length; i++) {
      if (personVotes.containsKey(persons[i])) {
        personVotes.get(persons[i]).addVote();
      } else {
        personVotes.put(persons[i], new Person(persons[i]));
      }

      Person person = personVotes.get(persons[i]);
      if (person.vote >= max) {
        max = person.vote;
        timeTopVote.put(times[i], person);
      }
    }
  }

  public int q(int t) {
    return timeTopVote.floorEntry(t).getValue().id;
  }

  class Person {
    int id;
    int vote;

    Person(int id) {
      this.id = id;
      vote = 1;
    }

    void addVote() {
      vote++;
    }
  }

}
