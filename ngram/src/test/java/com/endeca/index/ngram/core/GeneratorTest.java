/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endeca.index.ngram.core;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Colin.You
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class GeneratorTest {

    @Autowired
    private Generator generator;

    public GeneratorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGenerate() {
        List<GramValue> gramValues = generator.generate(" The  test  method ");
        Assert.assertTrue(gramValues.size() > 0);
        for (GramValue gramValue : gramValues) {
            System.out.println(gramValue);
        }
        Assert.assertTrue(gramValues.contains(new GramValue("the test")));
        Assert.assertTrue(gramValues.contains(new GramValue("test method")));
        Assert.assertTrue(gramValues.contains(new GramValue("the test method")));
    }
    
    @Test
    public void testGenerateForChinese() {
        List<GramValue> gramValues = generator.generate(" 输 入 资料 立刻 开始 ");
        Assert.assertTrue(gramValues.size() > 0);
//        for (GramValue gramValue : gramValues) {
//            System.out.println(gramValue);
//        }
        Assert.assertTrue(gramValues.contains(new GramValue("输入")));
        Assert.assertTrue(gramValues.contains(new GramValue("资料立")));
        Assert.assertTrue(gramValues.contains(new GramValue("立刻开始")));
        Assert.assertTrue(gramValues.contains(new GramValue("输入资料立刻")));
        Assert.assertTrue(gramValues.contains(new GramValue("资料立刻开始")));
    }
    

    @Autowired
    public void setGenerator(SimpleGramGenerator generator) {
        this.generator = generator;
    }

}
