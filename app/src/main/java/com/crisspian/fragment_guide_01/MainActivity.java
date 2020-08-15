package com.crisspian.fragment_guide_01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import com.crisspian.fragment_guide_01.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;
private boolean isFragmeentShow= false;
public static final String KEY_ONE="KEY_ONE";
    public static final String KEY_TWO="KEY_TWO";
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putBoolean(KEY_ONE,isFragmeentShow);
        outState.putString(KEY_TWO,"OPEN");

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        if(savedInstanceState!=null){
           isFragmeentShow=savedInstanceState.getBoolean(KEY_ONE);
           binding.button.setText(savedInstanceState.getString(KEY_TWO,"ups"));

        }
        if(isFragmeentShow){
            binding.button.setText("Close");
        }


        //devuelve la vista  completa
        setContentView(binding.getRoot());
        binding.button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        if (!isFragmeentShow){
            showFragmento();
        }  else {
            closeFragment();
        }
    }
});
    }



    //metodo

    private void showFragmento(){

        //generamos la instancia del fragmento
       FistFragment firstfrangment =FistFragment.newInstance("","");
        //necesitamos obtener la instancia del Fergment,anager
        FragmentManager frangManager=getSupportFragmentManager();
        //obtenemos e instanciamos la transacción
        FragmentTransaction fragmentTransaction =frangManager.beginTransaction();
        //añadir fragmento a la pila o memoria
        //añadir el fragmento y lo asociamos al contenedor donde se mostrará

        //.remove cierro fragmento
        fragmentTransaction.add(R.id.Contentfragment,firstfrangment)
               // .addToBackStack(null)
                .commit();
                //si comento addToBackStack no hay nada en pila y si presiona botón hacia atrás se cierra el programa
                //no almacena lo que tiene la pila y las veces que presione el botón.

                binding.button.setText("Close");
                isFragmeentShow=true;

    }

    private  void  closeFragment(){
        FragmentManager fragmentManager= getSupportFragmentManager();
        //buccando el fragmento
        Fragment fragment= fragmentManager.findFragmentById(R.id.Contentfragment);

        if (fragment != null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragment).commit();
        }
        binding.button.setText("Open");
        isFragmeentShow=false;


    }
}