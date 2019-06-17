package com.pattern.creation.build;

/**
 * @author jhons
 * @since 2019/5/31 16:07
 */
public interface PersonBuilder {
    void buildHead();
    void buildBody();
    void buildFoot();
    Person buildPerson();

}
