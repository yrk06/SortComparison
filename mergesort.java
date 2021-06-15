public class mergesort<T extends Comparable<T>>{
	 /**
	* Método que recebe um array de inteiros e dois inteiros referentes ao início e ao fim
	* da ordenação desse array, o que nos garante o poder de escolher uma faixa do array
	* para ser ordenado.
	*
	* @param array
	* @param indiceInicio
	* @param indiceFim
	*/
	public void ordena(T[] array, int indiceInicio, int indiceFim) {

		// Condicional que verifica a validade dos parâmetros passados.
		if (array != null && indiceInicio < indiceFim && indiceInicio >= 0 &&
		 indiceFim < array.length && array.length != 0) {
			int meio = ((indiceFim + indiceInicio) / 2);

			ordena(array, indiceInicio, meio);
			ordena(array, meio + 1, indiceFim);

			merge(array, indiceInicio, meio, indiceFim);
		}

	}

	/**
	* O merge consiste na junção de duas listas já ordenadas.
	* Usa um array auxiliar.
	*
	* @param array
	* @param indiceInicio
	* @param meio
	* @param indiceFim
	*/
	public void merge(T[] array, int indiceInicio, int meio, int indiceFim) {

		T[] auxiliar =(T[]) new Comparable[array.length];
		//Copiando o trecho da lista que vai ser ordenada
		for (int i = indiceInicio; i <= indiceFim; i++) {
			auxiliar[i] = array[i];
		}

		//Índices auxiliares
		int i = indiceInicio;
		int j = meio + 1;
		int k = indiceInicio;

		//Junção das listas ordenadas
		while (i <= meio && j <= indiceFim) {
			if (auxiliar[i].compareTo(auxiliar[j]) < 0) {
				array[k] = auxiliar[i];
				i++;
			} else {
				array[k] = auxiliar[j];
				j++;
			}
			k++;
		}

		//Append de itens que não foram usados na Junção
		while (i <= meio) {
			array[k] = auxiliar[i];
			i++;
			k++;
		}

		//Append de itens que não foram usados na Junção
		while (j <= indiceFim) {
			array[k] = auxiliar[j];
			j++;
			k++;
		}
	}
}