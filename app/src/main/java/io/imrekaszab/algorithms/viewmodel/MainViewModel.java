package io.imrekaszab.algorithms.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.imrekaszab.algorithms.model.AlgorithmType;
import io.imrekaszab.algorithms.model.BubbleSort;
import io.imrekaszab.algorithms.model.item.AlgorithmItemModel;
import io.imrekaszab.algorithms.model.item.ItemModel;
import io.imrekaszab.algorithms.model.item.SectionAlgorithmItemModel;

@HiltViewModel
public class MainViewModel extends ViewModel {

    public MutableLiveData<ArrayList<ItemModel>> algorithms = new MutableLiveData<>();

    @Inject
    public MainViewModel() {
        ArrayList<ItemModel> items = new ArrayList<>();

        items.add(new SectionAlgorithmItemModel(AlgorithmType.SORT));
        items.add(new AlgorithmItemModel(new BubbleSort()));

        algorithms.postValue(items);
    }
}
