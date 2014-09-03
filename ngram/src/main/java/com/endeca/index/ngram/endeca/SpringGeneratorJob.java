/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endeca.index.ngram.endeca;

import com.endeca.index.ngram.core.Generator;
import com.endeca.index.ngram.core.GramValue;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Colin.You
 */
public class SpringGeneratorJob {

    private static final Logger LOG = Logger.getLogger(SpringGeneratorJob.class);
    private String springContextPath = "spring-context.xml";
    private String generatorBeanName = "generator";
    private final Generator generator;

    public SpringGeneratorJob() {
        ApplicationContext context = new ClassPathXmlApplicationContext(springContextPath);
        generator = (Generator) context.getBean(generatorBeanName);
        if (generator == null) {
            throw new RuntimeException("Retriving bean generator failed from spring context.");
        }
    }

    public String[] getNGrams(String source) {
        List<GramValue> gramValues = generator.generate(source);
        String[] reValues = new String[gramValues.size()];
        LOG.debug("NGram key words:");
        for (int i = 0; i < gramValues.size(); i++) {
            reValues[i] = gramValues.get(i).getSource();
            LOG.debug(reValues[i]);
        }
        return reValues;
    }

    public String getSpringContextPath() {
        return springContextPath;
    }

    public void setSpringContextPath(String springContextPath) {
        this.springContextPath = springContextPath;
    }

    public String getGeneratorBeanName() {
        return generatorBeanName;
    }

    public void setGeneratorBeanName(String generatorBeanName) {
        this.generatorBeanName = generatorBeanName;
    }

}
