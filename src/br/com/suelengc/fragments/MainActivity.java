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

		/** Como o menu sempre existirá, instâncio ele fora da condição */
		MenuFragment menuFrag = new MenuFragment();
		
		if (findViewById(R.id.main) != null) {
			/** Se for acessodado de um smartphone o espaço main existirá */
			
			/** Adiciona o menu no único espaço */
			getSupportFragmentManager().beginTransaction().add(R.id.main, menuFrag).commit(); 
		
		} else if (findViewById(R.id.content) != null) {
			/** Se for acessodado de um tablet o espaço main não existirá, existirá o menu e content */
			
			/** Pega a transação */
			FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
			
			/** Coloca o fragment de menu do lado esquerdo e o fragment de conteúdo do lado direito */
			transaction.add(R.id.menu, menuFrag); 
			transaction.add(R.id.content, new ContentFragment()); 
			
			/** Confirma as transações */
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

			/** Pega a transação */
			FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
			
			if (findViewById(R.id.main) != null) {
				/** Se for acessodado de um smartphone o espaço main existirá */
				
				/** Adiciona o fragment com o novo conteúdo no único espaço */
				transaction.replace(R.id.main, newFragment); 
				
				/** Adiciona o fragment a backstack */
				transaction.addToBackStack(null);
				
			} else if (findViewById(R.id.content) != null) {
				/** Se for acessodado de um tablet o espaço main não existirá, existirá o menu e content */
				
				/** Coloca o fragment com o novo conteúdo do lado direito */
				transaction.replace(R.id.content, newFragment); 
			}

			/** Confirma a transação */
			transaction.commit();
		}
	}

	/** 
	 * Método auxiliar que faz a geração do ContentFragment com o conteúdo adequado ao menu clicado 
	 * Na prática é provável que você não utilize um método como este pois você terá fragments específicos 
	 */
	private Fragment getNewFragment(int menu) {
		/** Cria instância de ContentFragment */
		ContentFragment fragment = new ContentFragment();
		
		/** Adiciona um argumento indicando qual menu foi clicado */
		Bundle args = new Bundle();
		args.putInt("menu", menu);
		fragment.setArguments(args);
		
		/** Retorna o fragment criado */
		return fragment;
	}
}
