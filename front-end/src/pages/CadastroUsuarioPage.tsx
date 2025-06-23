import { useForm } from 'react-hook-form'
import type Usuario from '../interfaces/Usuario'


const cadastrarUsuario = (data: any) => {
    const novoUsuario : Usuario = {
        nome: data.nome,
        email: data.email,
        endereco: data.endereco
    }
    console.log(novoUsuario);
    //useCadastrarUsuario();
}

const CadastroUsuarioPage = () => {

    const {register, handleSubmit} = useForm();
  return (
    <div>
        <form onSubmit={ handleSubmit(cadastrarUsuario)}>
            <input {...register('nome')} placeholder='Nome'/>
            <input {...register('email')} placeholder='Email'/>
            <input {...register('endereco')} placeholder='Endereço'/>
            <input type="submit" />

        </form>
    </div>
  )
}

export default CadastroUsuarioPage