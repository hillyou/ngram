/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endeca.index.ngram.endeca;

import com.endeca.edf.adapter.Adapter;
import com.endeca.edf.adapter.AdapterConfig;
import com.endeca.edf.adapter.AdapterException;
import com.endeca.edf.adapter.AdapterHandler;
import com.endeca.edf.adapter.PVal;
import com.endeca.edf.adapter.Record;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Colin.You
 */
public class RecordAdapter implements Adapter {

    private static final Logger LOG = Logger.getLogger(RecordAdapter.class);
    private static final String SOURCEPROP_KEY = "SOURCEPROP";
    private static final String TARGETPROP_KEY = "TARGETPROP";
    private final SpringGeneratorJob generatorJob = new SpringGeneratorJob();

    @Override
    public void execute(AdapterConfig config, AdapterHandler handler) throws AdapterException {
        LOG.info("Invoking execute method");
        String[] sourceprops = config.get(SOURCEPROP_KEY);
        String targetprop = config.first(TARGETPROP_KEY);
        for (String sourceprop : sourceprops) {
            LOG.info(sourceprop);
        }
        LOG.info("Pass through target property name" + targetprop);

        if (sourceprops == null || sourceprops.length < 1 || targetprop == null || targetprop.trim().isEmpty()) {
            throw new AdapterException("Pass Throughs arguments '" + SOURCEPROP_KEY + "' or '" + TARGETPROP_KEY + "' not declared.");
        }
        List<String> sourceList = Arrays.asList(sourceprops);
        LOG.info("Total records number " + handler.getNumInputs());
        // loop through all input sources of this manipulator
        for (int inp = 0; inp < handler.getNumInputs(); inp++) {
            LOG.info("Current record index " + inp);
            // create this flag for testing in our while loop, below
            boolean hasMoreRecords = true;
            // loop through all of the records for the current input
            while (hasMoreRecords) {
                // get the records, one by one, from the current input source.
                Record rec = handler.getRecord(inp);
                LOG.info("Current record " + rec);
                // when we are out of records, the last record will be null.
                if (rec != null) {
                    String sourcepropValue = null; // placeholder for our source property
                    // each record is a collection of properties.
                    // loop through the properties to find the one we want.
                    // if we are looking for multiple different properties of a single
                    // record, it may be more efficient to stuff them into a Map.
                    for (PVal prop : rec) {
                        if (sourceList.contains(prop.getName())) {
                            // we found the property we are looking for. Save its value.
                            sourcepropValue = prop.getValue();
                            break;
                        }
                    }
                    LOG.info("property value " + sourcepropValue);
                    // If we found the sourceprop, copy its
                    // value into another prop, add the new prop to the
                    // record, and write to the Forge log.
                    if (sourcepropValue != null) {
                        String[] keywords = generatorJob.getNGrams(sourcepropValue);
                        PVal[] pVals = rec.toArray();
                        for (String keyword : keywords) {
                            Record newRec = new Record();
                            newRec.add(pVals);
                            PVal pVal = new PVal(targetprop, keyword);
                            newRec.add(pVal);
                            LOG.info("Creating new property " + pVal);
                            // we must emit() each record we want to pass out of this
                            // manipulator into the next downstream component (e.g. PropertyMapper)
                            handler.emit(newRec);
                        }
                    }
                } else {
                    hasMoreRecords = false;
                }
            }
        }
    }
}
