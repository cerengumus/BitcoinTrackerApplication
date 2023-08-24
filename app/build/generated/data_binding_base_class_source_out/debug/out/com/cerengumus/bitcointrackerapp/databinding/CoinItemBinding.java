// Generated by view binder compiler. Do not edit!
package com.cerengumus.bitcointrackerapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.cerengumus.bitcointrackerapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CoinItemBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final CardView coinsItemCardView;

  @NonNull
  public final TextView coinsItemChangeTextView;

  @NonNull
  public final ImageView coinsItemImageView;

  @NonNull
  public final ConstraintLayout coinsItemMainLayout;

  @NonNull
  public final TextView coinsItemNameTextView;

  @NonNull
  public final TextView coinsItemPriceTextView;

  @NonNull
  public final TextView coinsItemSymbolTextView;

  @NonNull
  public final ImageView favouriteImageView;

  private CoinItemBinding(@NonNull CardView rootView, @NonNull CardView coinsItemCardView,
      @NonNull TextView coinsItemChangeTextView, @NonNull ImageView coinsItemImageView,
      @NonNull ConstraintLayout coinsItemMainLayout, @NonNull TextView coinsItemNameTextView,
      @NonNull TextView coinsItemPriceTextView, @NonNull TextView coinsItemSymbolTextView,
      @NonNull ImageView favouriteImageView) {
    this.rootView = rootView;
    this.coinsItemCardView = coinsItemCardView;
    this.coinsItemChangeTextView = coinsItemChangeTextView;
    this.coinsItemImageView = coinsItemImageView;
    this.coinsItemMainLayout = coinsItemMainLayout;
    this.coinsItemNameTextView = coinsItemNameTextView;
    this.coinsItemPriceTextView = coinsItemPriceTextView;
    this.coinsItemSymbolTextView = coinsItemSymbolTextView;
    this.favouriteImageView = favouriteImageView;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static CoinItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CoinItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.coin_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CoinItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      CardView coinsItemCardView = (CardView) rootView;

      id = R.id.coinsItemChangeTextView;
      TextView coinsItemChangeTextView = ViewBindings.findChildViewById(rootView, id);
      if (coinsItemChangeTextView == null) {
        break missingId;
      }

      id = R.id.coinsItemImageView;
      ImageView coinsItemImageView = ViewBindings.findChildViewById(rootView, id);
      if (coinsItemImageView == null) {
        break missingId;
      }

      id = R.id.coinsItemMainLayout;
      ConstraintLayout coinsItemMainLayout = ViewBindings.findChildViewById(rootView, id);
      if (coinsItemMainLayout == null) {
        break missingId;
      }

      id = R.id.coinsItemNameTextView;
      TextView coinsItemNameTextView = ViewBindings.findChildViewById(rootView, id);
      if (coinsItemNameTextView == null) {
        break missingId;
      }

      id = R.id.coinsItemPriceTextView;
      TextView coinsItemPriceTextView = ViewBindings.findChildViewById(rootView, id);
      if (coinsItemPriceTextView == null) {
        break missingId;
      }

      id = R.id.coinsItemSymbolTextView;
      TextView coinsItemSymbolTextView = ViewBindings.findChildViewById(rootView, id);
      if (coinsItemSymbolTextView == null) {
        break missingId;
      }

      id = R.id.favouriteImageView;
      ImageView favouriteImageView = ViewBindings.findChildViewById(rootView, id);
      if (favouriteImageView == null) {
        break missingId;
      }

      return new CoinItemBinding((CardView) rootView, coinsItemCardView, coinsItemChangeTextView,
          coinsItemImageView, coinsItemMainLayout, coinsItemNameTextView, coinsItemPriceTextView,
          coinsItemSymbolTextView, favouriteImageView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}