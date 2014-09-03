/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endeca.index.ngram.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Colin.You
 */
public class DefaultDimensionParser extends AbstractDimensionParser {

    private static final Logger LOG = Logger.getLogger(DefaultDimensionParser.class);
    private static final String DIMENSION_SPLITOR = ",";
    private static final String DIMENSION_RANGE_SPLITOR = "-";
    private List<Integer> dimensionList;

    public DefaultDimensionParser(String dimensionString) {
        parseDimensions(dimensionString);
    }

    @Override
    public int[] getDimensions() {
        if (this.dimensionList == null || this.dimensionList.isEmpty()) {
            return null;
        }
        Integer[] dimensionsObjs = new Integer[this.dimensionList.size()];
        this.dimensionList.toArray(dimensionsObjs);
        int[] dimensions = new int[dimensionsObjs.length];
        for (int i = 0; i < dimensionsObjs.length; i++) {
            dimensions[i] = dimensionsObjs[i];
        }
        return dimensions;
    }

    private void parseDimensions(String dimensionString) {
        String[] dimensions = dimensionString.replaceAll("\\p{Space}", "").split(DIMENSION_SPLITOR);
        if (dimensions.length > 0) {
            for (String dimension : dimensions) {
                if (dimension.contains(DIMENSION_RANGE_SPLITOR)) {
                    String[] rangeDimension = dimension.split(DIMENSION_RANGE_SPLITOR);
                    if (rangeDimension.length == 2) {
                        int min = Integer.parseInt(rangeDimension[0].trim());
                        int max = Integer.parseInt(rangeDimension[1].trim());
                        if (min <= max) {
                            for (int i = min; i <= max; i++) {
                                addDimension(i);
                            }
                        } else {
                            LOG.error("Declare dimension range '" + dimension + "' incorrectly, the right side dimension must be greater than left side");
                        }
                    } else {
                        LOG.error("Declare dimension range '" + dimension + "' incorrectly.");
                    }
                } else {
                    addDimension(Integer.parseInt(dimension.trim()));
                }
            }
        }
    }

    private synchronized void addDimension(int dimension) {
        if (this.dimensionList == null) {
            this.dimensionList = Collections.synchronizedList(new ArrayList());
        }
        if (super.getMaxDimension() > 0) {
            if (super.getMaxDimension() >= dimension) {
                this.dimensionList.add(dimension);
            } else {
                LOG.info("Skip dimenion '" + dimension + "', because it is greater than max limitation '" + super.getMaxDimension() + "'");
            }
        } else {
            dimensionList.add(dimension);
        }
    }

}
