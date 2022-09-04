package edu.eci.cvds.tdd.registry;

import java.util.HashMap;
public class Registry {

    HashMap<String, Integer> idRegistradas = new HashMap<String, Integer>();
    public RegisterResult registerVoter(Person p) {

        if (p.getAge() < 0) {
            return RegisterResult.INVALID_AGE;
        }
        if (!p.isAlive()) {
            return RegisterResult.DEAD;
        }
        if (p.getAge() < 18) {
            return RegisterResult.UNDERAGE;
        }
        if (idRegistradas.containsValue(p.getId())) {
            return RegisterResult.DUPLICATED;
        }
        idRegistradas.put(p.getName(),p.getId());
        return RegisterResult.VALID;
    }
}
