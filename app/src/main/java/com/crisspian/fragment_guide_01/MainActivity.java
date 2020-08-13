package com.crisspian.fragment_guide_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.crisspian.fragment_guide_01.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding=ActivityMainBinding.inflate(getLayoutInflater());
        //devuelve la vista  completa
        setContentView(binding.getRoot());
        binding.button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
 showFragmento();
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
        fragmentTransaction.add(R.id.Contentfragment,firstfrangment).addToBackStack(null).commit();


    }
}