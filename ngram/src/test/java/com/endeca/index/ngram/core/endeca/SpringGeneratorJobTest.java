/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endeca.index.ngram.core.endeca;

import com.endeca.index.ngram.endeca.SpringGeneratorJob;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Colin.You
 */
public class SpringGeneratorJobTest {

    public SpringGeneratorJobTest() {
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
    public void testGetNGrams() {
        SpringGeneratorJob springGeneratorJob = new SpringGeneratorJob();
        String[] grams = springGeneratorJob.getNGrams("run the test");
        Assert.assertTrue(grams.length == 3);
    }
}
