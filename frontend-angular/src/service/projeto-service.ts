import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cidade } from '@domain/cidade';
import { Observable, from } from 'rxjs';

@Injectable()
export class ProjetoService {

  // private urlBase: string = `${environment.apiUrl}${environment.urlIngredientes}`;
  private urlBase: string = 'http://localhost:8080/mirante/cidades'

  constructor(private http: HttpClient) {}

    //------------------------------------------------
    /** Recupera a lista de cidades */
    //------------------------------------------------
    pesquisarCidades(): Observable<Cidade[]> {
      return this.http.get<Cidade[]>(this.urlBase);
    }

    //------------------------------------------------
    /** Exclui a cidade informada */
    //------------------------------------------------
    excluir(cidade: Cidade): Observable<any> {
      const url: string = this.urlBase + '/' + cidade.id;
      return this.http.delete(url)
    }

    //------------------------------------------------
    /** Salva a cidade informada */
    //------------------------------------------------
    salvar(cidade: Cidade): Observable<any> {
        // TODO: chamar backend
      if(cidade.id) {
        return this.http.put(this.urlBase, cidade);
      } else {
        return this.http.post(this.urlBase, cidade);
      }
    }

}
