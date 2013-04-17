package br.com.suelengc.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MenuFragment extends Fragment {
	
	/** Atributo de callback */
	OnItemClickedCallBack callBack;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		/** Infla o layout */
		View view = inflater.inflate(R.layout.menu, container, false);

		/** Recupera os botões de menu e adiciona o listener de click */
		((Button) view.findViewById(R.id.menu1)).setOnClickListener(new OnClickMenuItemListener());;
		((Button) view.findViewById(R.id.menu2)).setOnClickListener(new OnClickMenuItemListener());;
		((Button) view.findViewById(R.id.menu3)).setOnClickListener(new OnClickMenuItemListener());;
		((Button) view.findViewById(R.id.menu4)).setOnClickListener(new OnClickMenuItemListener());;
		
		/** Retorna a view para ser exibida */
		return view;
	}
	
	/** Garante que a Activity que irá carregar o fragment implementa a interface de callback */
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
		try {
			callBack = (OnItemClickedCallBack) activity;
		} catch (ClassCastException e) {
			Log.e("MenuFragment", activity.toString() + " must implement OnItemClickedCallBack");
		}
	}
	
	/** Listener do click do botão */
	protected class OnClickMenuItemListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			/** Chama o método de callback passando o id do botão clicado */
			callBack.onItemClicked(v.getId());
		}
	}

}
