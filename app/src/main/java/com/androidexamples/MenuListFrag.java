package com.androidexamples;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MenuListFrag extends Fragment {
    Button optMenu, ctxMenu, popupMenu;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_list, container, false);
//      finding view
        optMenu = view.findViewById(R.id.opt_menu);
        ctxMenu = view.findViewById(R.id.ctx_menu);

        registerForContextMenu(ctxMenu);

        optMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MenuListFrag menuFrag = new MenuListFrag();
                FragmentTransaction ft = getFragmentManager().beginTransaction()
                        .replace(R.id.container, new OptionMenuFrag());
                ft.commit();
            }
        });
        return view;
    }

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v,
                                    @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.opt_menu, menu);
    }
}
