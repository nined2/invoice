package com.example.invoice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ProductListAdapter extends BaseAdapter {

    private Context context;
    private List<Product> productList;

    public ProductListAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.product_list_item, null);
        }

        // Get the product at the specified position
        Product product = productList.get(position);

        // Populate the list item with product details
        TextView productNameTextView = view.findViewById(R.id.productNameTextView);
        TextView productPriceTextView = view.findViewById(R.id.productPriceTextView);
        TextView productQuantityTextView = view.findViewById(R.id.productQuantityTextView);

        productNameTextView.setText(product.getName());
        productPriceTextView.setText("$" + product.getPrice());
        productQuantityTextView.setText("Quantity: " + product.getQuantity());

        return view;
    }
}

