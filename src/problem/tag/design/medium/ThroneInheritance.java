package problem.tag.design.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1600. Throne Inheritance
 * <p></p>
 * https://leetcode.com/problems/throne-inheritance/
 * <p></p>
 */
public class ThroneInheritance {

  private Map<String, Kin> kindom;
  private String king;

  public ThroneInheritance(String kingName) {
    king = kingName;
    kindom = new HashMap<>();
    kindom.put(kingName, new Kin(kingName));
  }

  public void birth(String parentName, String childName) {
    Kin parent = kindom.get(parentName);
    Kin child = new Kin(childName);
    parent.birth(child);
    kindom.put(childName, child);
  }

  public void death(String name) {
    kindom.get(name).markDead();
  }

  public List<String> getInheritanceOrder() {
    List<String> inheritance = new ArrayList<>(kindom.size());
    getInheritance(kindom.get(king), inheritance);
    return inheritance;
  }

  private void getInheritance(Kin kin, List<String> inheritance) {
    if (!kin.dead) {
      inheritance.add(kin.name);
    }
    for (Kin child : kin.children) {
      getInheritance(child, inheritance);
    }
  }

  class Kin {
    String name;
    List<Kin> children;
    boolean dead;

    Kin(String name) {
      this.name = name;
      this.children = new ArrayList<>();
      this.dead = false;
    }

    void markDead() {
      dead = true;
    }

    void birth(Kin child) {
      children.add(child);
    }
  }

}
