package io.imrekaszab.algorithms.model.item;

import io.imrekaszab.algorithms.model.Algorithm;

public class AlgorithmItemModel implements ItemModel {
    private Algorithm algorithm;

    public AlgorithmItemModel(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public Algorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }
}
