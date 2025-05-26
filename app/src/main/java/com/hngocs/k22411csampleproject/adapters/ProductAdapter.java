package com.hngocs.k22411csampleproject.adapters;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.hngocs.k22411csampleproject.R;
import com.hngocs.k22411csampleproject.models.Product;

public class ProductAdapter extends ArrayAdapter<Product> {
    Activity context;
    int resource;

    public ProductAdapter(@NonNull Activity context, int resource) {
        super(context, resource);
        this.context=context;
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        // nhan ban giao dien
        View item=inflater.inflate(resource,null);
        // luc nay, toan bo giao dien trong resource da duoc nap vao o nho va mo hinh hoa huong doi tuong
        // va duoc quan ly boi bien item (tong tai giao dien 1 dong)
        TextView txtProductID=item.findViewById(R.id.txtProductID);
        TextView txtProductName=item.findViewById(R.id.txtProductName);
        TextView txtProductQuantity=item.findViewById(R.id.txtProductQuantity);
        TextView txtProductPrice=item.findViewById(R.id.txtProductPrice);
        ImageView imgProduct=item.findViewById(R.id.imgProduct);
        ImageView imgCart=item.findViewById(R.id.imgCart);

        // Truy suat data model o dong position (doi so 1) ma no dang nhan ban
        Product p=getItem(position);
        // sau do rai du lieu tu Product len giao dien cho nguoi dung xem
        txtProductID.setText(p.getId()+"");
        txtProductName.setText(p.getName());
        txtProductQuantity.setText(p.getQuantity()+"");
        txtProductPrice.setText(p.getPrice()+"VND");
        imgProduct.setImageResource(p.getImage_id());
        // xu ly nhan mua hang (bam vao Cart) --> tinh sau


        return item;
    }
}
