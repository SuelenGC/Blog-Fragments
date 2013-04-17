package br.com.suelengc.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements OnItemClickedCallBack {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		/** Como o menu sempre existir�, inst�ncio ele fora da condi��o */
		MenuFragment menuFrag = new MenuFragment();
		
		if (findViewById(R.id.main) != null) {
			/** Se for acessodado de um smartphone o espa�o main existir� */
			
			/** Adiciona o menu no �nico espa�o */
			getSupportFragmentManager().beginTransaction().add(R.id.main, menuFrag).commit(); 
		
		} else if (findViewById(R.id.content) != null) {
			/** Se for acessodado de um tablet o espa�o main n�o existir�, existir� o menu e content */
			
			/** Pega a transa��o */
			FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
			
			/** Coloca o fragment de menu do lado esquerdo e o fragment de conte�do do lado direito */
			transaction.add(R.id.menu, menuFrag); 
			transaction.add(R.id.content, new ContentFragment()); 
			
			/** Confirma as transa��es */
			transaction.commit();
		}
	}

	@Override
	public void onItemClicked(int menuItem) {
		Fragment newFragment = null;

		switch (menuItem) {
		case R.id.menu1:
			/** Fragment que deve ser aberto quando for o menu 1 */
			newFragment = getNewFragment(1); 
			break;

		case R.id.menu2:
			/** Fragment que deve ser aberto quando for o menu 2 */
			newFragment = getNewFragment(2); 
			break;

		case R.id.menu3:
			/** Fragment que deve ser aberto quando for o menu 3 */
			newFragment = getNewFragment(3); 
			break;
			
		case R.id.menu4:
			/** Fragment que deve ser aberto quando for o menu 4 */
			newFragment = getNewFragment(4); 
			break;
		}
		
		if (newFragment != null) {

			/** Pega a transa��o */
			FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
			
			if (findViewById(R.id.main) != null) {
				/** Se for acessodado de um smartphone o espa�o main existir� */
				
				/** Adiciona o fragment com o novo conte�do no �nico espa�o */
				transaction.replace(R.id.main, newFragment); 
				
				/** Adiciona o fragment a backstack */
				transaction.addToBackStack(null);
				
			} else if (findViewById(R.id.content) != null) {
				/** Se for acessodado de um tablet o espa�o main n�o existir�, existir� o menu e content */
				
				/** Coloca o fragment com o novo conte�do do lado direito */
				transaction.replace(R.id.content, newFragment); 
			}

			/** Confirma a transa��o */
			transaction.commit();
		}
	}

	/** 
	 * M�todo auxiliar que faz a gera��o do ContentFragment com o conte�do adequado ao menu clicado 
	 * Na pr�tica � prov�vel que voc� n�o utilize um m�todo como este pois voc� ter� fragments espec�ficos 
	 */
	private Fragment getNewFragment(int menu) {
		/** Cria inst�ncia de ContentFragment */
		ContentFragment fragment = new ContentFragment();
		
		/** Adiciona um argumento indicando qual menu foi clicado */
		Bundle args = new Bundle();
		args.putInt("menu", menu);
		fragment.setArguments(args);
		
		/** Retorna o fragment criado */
		return fragment;
	}
}
