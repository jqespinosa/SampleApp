package com.espinosa.joey.sampleapplication.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JEspinosa on 16/03/2017.
 */
public class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<BaseRecyclerViewAdapter.BindingHolder> {

    private final List<T> items;
    private int layoutId;
    private int brId;
    public ItemClickListener<T> listener;

    public interface ItemClickListener<T> {

        void onItemClick(View v, T item, int position);
    }

    public class BindingHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ViewDataBinding binding;

        public BindingHolder(View v) {
            super(v);
            binding = DataBindingUtil.bind(v);
            v.setOnClickListener(this);
        }

        public ViewDataBinding getBinding() {
            return binding;
        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            T item = items.get(position);
            listener.onItemClick(v, item, position);
        }
    }

    public BaseRecyclerViewAdapter(List<T> items, int layoutId, int brId, ItemClickListener<T> listener) {
        this.items = new ArrayList<>(items);
        this.layoutId = layoutId;
        this.brId = brId;
        this.listener = listener;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int type) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        BindingHolder holder = new BindingHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(BaseRecyclerViewAdapter.BindingHolder holder, int position) {
        T item = items.get(position);
        holder.getBinding().setVariable(brId, item);
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void animateTo(List<T> models) {
        applyAndAnimateRemovals(models);
        applyAndAnimateAdditions(models);
        applyAndAnimateMovedItems(models);
    }

    private void applyAndAnimateRemovals(List<T> newModels) {
        for (int i = items.size() - 1; i >= 0; i--) {
            final T model = items.get(i);
            if (!newModels.contains(model)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<T> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final T model = newModels.get(i);
            if (!items.contains(model)) {
                addItem(i, model);
            }
        }
    }

    private void applyAndAnimateMovedItems(List<T> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final T model = newModels.get(toPosition);
            final int fromPosition = items.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

    public T removeItem(int position) {
        final T model = items.remove(position);
        notifyItemRemoved(position);
        return model;
    }

    public void addItem(int position, T model) {
        items.add(position, model);
        notifyItemInserted(position);
    }

    public void moveItem(int fromPosition, int toPosition) {
        final T model = items.remove(fromPosition);
        items.add(toPosition, model);
        notifyItemMoved(fromPosition, toPosition);
    }

    public void clear() {
        int size = this.items.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                this.items.remove(0);
            }

            this.notifyItemRangeRemoved(0, size);
        }
    }
}
