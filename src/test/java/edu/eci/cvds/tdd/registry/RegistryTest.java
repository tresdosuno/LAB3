package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {

    private Registry registry = new Registry();

    /**
     * Test para ver si el registro es válido.
     */
    @Test
    public void validateRegistryResult() {
        Person person = new Person("Juan Pérez", 123456789, 87, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }

    /**
     * Test para ver si el registro arroja que la persona está muerta.
     */
    @Test
    public void deadRegistryResult() {
        Person person = new Person("Juan Pérez", 123456789, 87, Gender.MALE, false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);
    }

    /**
     * Test para ver si el registro arroja que la persona es menor de edad.
     */
    @Test
    public void underageRegistryResult() {
        Person person = new Person("Juana Pérez", 122456789, 15, Gender.FEMALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    /**
     * Test para ver si el registro arroja que la persona tiene una edad
     * invalida.
     */
    @Test
    public void invalidAgeRegistryResult() {
        Person person = new Person("Álvaro Duque", 987654321, -21, Gender.UNIDENTIFIED, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }

    @Test
    public void duplicatedRegistryResult() {
        Person person1 = new Person("Pepito Pérez", 1234567890, 21, Gender.MALE, true);
        Person person = new Person("Pepito Pérez", 1234567890, 21, Gender.MALE, true);
        registry.registerVoter(person1);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DUPLICATED, result);
    }
}
