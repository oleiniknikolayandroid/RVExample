package com.example.rvexample.pagenation;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public abstract class PaginationListener extends RecyclerView.OnScrollListener {


    @NonNull
    private LinearLayoutManager layoutManager;


    /**
     * Supporting only LinearLayoutManager for now.
     */
    protected PaginationListener(@NonNull LinearLayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

    @Override
    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        if (dy > 0) {
            int visibleItemCount = layoutManager.getChildCount();
            int totalItemCount = layoutManager.getItemCount();
            int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
            if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount) {
                loadMoreItems();
            }
        }
    }

    protected abstract void loadMoreItems();

   public abstract boolean isLastPage();

    public abstract boolean isLoading();
}