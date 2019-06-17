package com.pattern.creation.build;

/**
 * @author jhons
 * @since 2019/5/31 16:09
 */
public class PersonDirector {
    public Person constructPerson(PersonBuilder pb) {
        pb.buildHead();
        pb.buildBody();
        pb.buildFoot();
        return pb.buildPerson();
    }
}
