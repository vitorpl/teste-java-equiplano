import { Cidade } from "./cidade";
import { Estado } from "./estado";

export interface Cliente {
    id:number;
    nome: string;
    cpf: string;
    estado: Estado; //transient
    cidade: Cidade;
}