package com.wit.ui.view.device;

import static org.chromium.base.ContextUtils.getApplicationContext;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.espressif.wifi_provisioning.databinding.FragmentDetailDeviceBinding;
import com.wit.data.classModel.MyDividerItemDecoration;
import com.wit.data.retrofit.device.DeviceResponse;
import com.wit.data.retrofit.events.PayloadResponse;
import com.wit.ui.adapters.DeviceAdapter;
import com.wit.ui.adapters.ListValueDeviceAdapter;
import java.util.ArrayList;
import java.util.List;

public class DetailDevice extends Fragment  implements DeviceAdapter.DeviceAdapterListener,ListValueDeviceAdapter.ValueDeviceAdapterListener{

    private FragmentDetailDeviceBinding binding;
    private DetailDeviceViewModel mViewModel;

    private List<PayloadResponse> valueDeviceList;
    private ListValueDeviceAdapter listValueDeviceAdapter;


    public static DetailDevice newInstance() {
        return new DetailDevice();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDetailDeviceBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        datamock();
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DetailDeviceViewModel.class);
        // TODO: Use the ViewModel
    }

    public void datamock(){
        //Mock
        //vertical
        valueDeviceList = new ArrayList<>();
        PayloadResponse objValueDevice = new PayloadResponse();
        valueDeviceList.add(objValueDevice);

        listValueDeviceAdapter = new ListValueDeviceAdapter(getActivity(), valueDeviceList, this);


        RecyclerView.LayoutManager mLayoutManager2 = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,
                false);
        binding.recyclerVertical.setLayoutManager(mLayoutManager2);
        binding.recyclerVertical.setItemAnimator(new DefaultItemAnimator());
        binding.recyclerVertical.addItemDecoration(new MyDividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL, 5));
        binding.recyclerVertical.setAdapter(listValueDeviceAdapter);
    }

    @Override
    public void onDeviceSelected(DeviceResponse contact) {

    }

    @Override
    public void onListValueDeviceSelected(PayloadResponse device) {

    }
}