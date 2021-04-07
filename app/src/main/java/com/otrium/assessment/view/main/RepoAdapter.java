package com.otrium.assessment.view.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.otrium.assessment.R;
import com.otrium.assessment.view.base.BaseRecyclerViewAdapter;
import com.otrium.service.models.Repo;

import java.util.ArrayList;

import butterknife.ButterKnife;

/*
 * Created by Kasunka Gallage on 2021-04-07,
 */

public class RepoAdapter extends BaseRecyclerViewAdapter<RecyclerView.ViewHolder, Repo> {

    public RepoAdapter() {
//        setData();
        setTempData();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        viewHolder = new RepoViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view_repo, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    private void setTempData(){
        ArrayList<Repo> repoArrayList = new ArrayList<>();
        repoArrayList.add(new Repo());
        repoArrayList.add(new Repo());
        repoArrayList.add(new Repo());
        repoArrayList.add(new Repo());
        repoArrayList.add(new Repo());

        setData(repoArrayList);
    }

    class RepoViewHolder extends RecyclerView.ViewHolder {

        public RepoViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
