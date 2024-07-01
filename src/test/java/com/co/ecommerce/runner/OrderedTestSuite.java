package com.co.ecommerce.runner;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        RegisterTest.class,
        AperturaTest.class,
        PagosTest.class
})
public class OrderedTestSuite {
}
