package io.imrekaszab.algorithms.model.item;

import io.imrekaszab.algorithms.model.AlgorithmType;

public class SectionAlgorithmItemModel implements ItemModel {
    private AlgorithmType type;

    public SectionAlgorithmItemModel(AlgorithmType type) {
        this.type = type;
    }

    public AlgorithmType getType() {
        return type;
    }

    public void setType(AlgorithmType type) {
        this.type = type;
    }
}
