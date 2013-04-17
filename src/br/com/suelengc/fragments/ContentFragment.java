package br.com.suelengc.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ContentFragment extends Fragment {

	int menuClicado = 0;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		/** Infla a view que deve ser exibida */
		View view = inflater.inflate(R.layout.content, container, false);
		
		/** Recupra o argumento de qual m�todo foi clicado */
		if (getArguments() != null) {
			Bundle args = getArguments();
			menuClicado = args.getInt("menu");
		}
		
		/** Preenche o conte�do do textview com a informa��o de qual menu foi clicado */
		TextView txt = (TextView) view.findViewById(R.id.txt);
		txt.setText("Conte�do do menu " + menuClicado);
		
		/** Retorna a view para ser exibida */
		return view;
	}
	
}
