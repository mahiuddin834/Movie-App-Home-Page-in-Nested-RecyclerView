package com.itnation.nestedmovie.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.database.DatabaseError;
import com.itnation.nestedmovie.Model.ParentItem;
import com.itnation.nestedmovie.repo.FirebaseRepo;

import java.util.List;

public class FirebaseViewModel extends ViewModel implements FirebaseRepo.OnRealtimeDbTaskComplete {

    MutableLiveData<List<ParentItem>> parentItemMutableLiveData = new MutableLiveData<>();
    MutableLiveData<DatabaseError> databaseErrorMutableLiveData = new MutableLiveData<>();
    FirebaseRepo firebaseRepo;

    public MutableLiveData<List<ParentItem>> getParentItemMutableLiveData() {
        return parentItemMutableLiveData;
    }

    public MutableLiveData<DatabaseError> getDatabaseErrorMutableLiveData() {
        return databaseErrorMutableLiveData;
    }

    public FirebaseViewModel() {
        firebaseRepo = new FirebaseRepo(this);
    }

    public void getAllData() {
        firebaseRepo.getAllData();
    }

    @Override
    public void onSuccess(List<ParentItem> parentItemList) {
        parentItemMutableLiveData.setValue(parentItemList);
    }

    @Override
    public void onFailure(DatabaseError error) {
        databaseErrorMutableLiveData.setValue(error);
    }
}