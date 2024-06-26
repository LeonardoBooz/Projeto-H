def abre_navegador(url):
    """
    Inicia uma instância do navegador Google Chrome, navega até a URL fornecida,
    maximiza a janela do navegador, aguarda o carregamento da página e registra 
    essas ações em um log.

    Parâmetros:
    url (str): A URL da página da web que deve ser aberta no navegador.

    Retorna:
    navegador (selenium.webdriver.Chrome): A instância do navegador Chrome após 
    navegar até a URL fornecida e maximizar a janela.
    
    Dependências:
    - A função escreve_no_log deve estar definida para registrar mensagens no log.
    - A classe Chrome do selenium.webdriver deve estar importada.
    - A função p.sleep deve estar importada do módulo time ou equivalente para pausar a execução.
    """
    
    escreve_no_log('================================Inicio=de=execução=================================')
    navegador = Chrome()
    navegador.get(url)
    navegador.maximize_window()
    # Aguarda o carregamento da página
    p.sleep(2)
    escreve_no_log('pagina carregada')
    return navegador

def metodomuitoloco(sdsds):
    dsdss = "sdsdsdssd" 


def verifica_abas_abertas():
        # Obtém todas as janelas abertas
    windows = gw.getAllTitles()

    # Imprime os títulos das janelas
    for window in windows:
        if '- Excel' in window:
            return True
        
    return False

def abre_navegador(url):
    escreve_no_log('================================Inicio=de=execução=================================')
    navegador = Chrome()
    navegador.get(url)
    navegador.maximize_window()
            #Aguarda o carregamento da pagina
    p.sleep(2)
    escreve_no_log('pagina carregada')
    return navegador

def filtro_marca_diretorios_para_nao_processar(df: pd.DataFrame):
    #Ao substuir o caminho de um diretorio por 'Marcado Para Não Processar', na função 'XXXX', retornara um dic com todas
    #os itens com  o valor 'Marcado Para Não Processar'
    escreve_no_log('Ignorando marcados para não processar...')
    df = remover_linha_por_valor_especifico(df, 'N', colunas=(('Processar(S/N)')))
    return df

def remover_linha_por_valor_especifico(df: pd.DataFrame, valor_procurado, colunas=True):
    # Removerá todas as ocorrências que tiverem o valor_procurado
    if colunas == True:
        colunas = df.columns
        for coluna in colunas:
            for n_linha in range(len(df)):
                valor = df[coluna][n_linha]
                if str(valor).lower() == str(valor_procurado).lower():
                    df = df.drop(n_linha)

def faz_login_verifica_erro(navegador: Chrome, dependencias):
    """
    A função verificara até 5 vezes de 5 em 5 minutos se o login foi bem sucedido, caso em nenhuma das tentativas seja bem sucedida
    lançara uma Exception LoginInicialErro
    """
    for e in range(5):
        if e != 0:
            #esperamos 5 minutos caso o login não seja bem sucedido, que é o tempo de espera caso o quiver não seja fechado corretamente
            sleep(300)
        else:
            sleep(2)
        preenche_login(navegador, dependencias)
        sleep(2)
        try:
            navegador.find_element(By.XPATH, '//*[@id="dashboard-grid"]/a[6]/div/div/h5')
            escreve_no_log('login_bem_sucedido ')
            return True
        except NoSuchElementException:
            escreve_no_log('Login mal_sucedido, esperando por 5 minutos para tentar denovo!')
    raise LoginInicialErro

def faz_login_verifica_erro(navegador: Chrome, dependencias):
    def faz_login_verifica_erros(navegador: Chrome, dependencias):
        pass


class Sdsdsd():

    def remover_linha_por_valor_especifico(df: pd.DataFrame, valor_procurado, colunas=True):
    # Removerá todas as ocorrências que tiverem o valor_procurado
        if colunas == True:
            colunas = df.columns
            for coluna in colunas:
                for n_linha in range(len(df)):
                    valor = df[coluna][n_linha]
                    if str(valor).lower() == str(valor_procurado).lower():
                        df = df.drop(n_linha)

    def faz_login_verifica_erro(navegador: Chrome, dependencias):
        def faz_login_verifica_erros(navegador: Chrome, dependencias):
            pass

    def faz_login_verifica_erro(navegador: Chrome, dependencias):
        """
        A função verificara até 5 vezes de 5 em 5 minutos se o login foi bem sucedido, caso em nenhuma das tentativas seja bem sucedida
        lançara uma Exception LoginInicialErro
        """
        for e in range(5):
            if e != 0:
                #esperamos 5 minutos caso o login não seja bem sucedido, que é o tempo de espera caso o quiver não seja fechado corretamente
                sleep(300)
            else:
                sleep(2)
            preenche_login(navegador, dependencias)
            sleep(2)
            try:
                navegador.find_element(By.XPATH, '//*[@id="dashboard-grid"]/a[6]/div/div/h5')
                escreve_no_log('login_bem_sucedido ')
                return True
            except NoSuchElementException:
                escreve_no_log('Login mal_sucedido, esperando por 5 minutos para tentar denovo!')
    raise LoginInicialErro

class A():
    def retorna_ultima_data(listas_apolice):
        '''
            Retorna a data de final_vigencia mais atual
        '''
        lista_final_vigencia = []
        for indice, apolice in enumerate(listas_apolice):
            dia, mes, ano = apolice['final_vigencia'].split('/')
            data_final_vigencia = date(int(ano), int(mes), int(dia))
            lista_final_vigencia.append(data_final_vigencia)
        return max(lista_final_vigencia)


    class B():
        def verifica_subestipulante(listas_apolices_validas, subestipulante_boleto_fatura):
            """
            Verifica qual subestipulante dentre as apolices encontradas é IGUAL ao subestipulante
            encontrado no boleto ou na fatura.

            A função retorna apenas uma apolice, se forem encontradas mais que uma lançara uma exceção
            """
            apolice_valida = False
            subestipulante_encontrado = False
            for apolice in listas_apolices_validas:
                subestipulante = unidecode(''.join(apolice['subestipulante'].lower().split(' ')))
                subestipulante_fatura = unidecode(''.join(subestipulante_boleto_fatura.lower().split(' ')))
                if subestipulante == subestipulante_fatura:
                    if subestipulante_encontrado:
                        raise MultiplosSubestipulanteEncontradosErro
                    subestipulante_encontrado = True
                    apolice_valida = apolice
            if apolice_valida == False or apolice_valida == None:
                escreve_no_log(f'Nenhum subestipulante foi encontrado.\nLista de apolices\n {listas_apolices_validas}')
                p.screenshot(f'DICT_APRAtividade004\\ima\\{subestipulante_boleto_fatura}-{datetime.now().strftime("%d.%m.%Y_%S")}.png')
                raise SubestipulanteNaoEncontradoErro
            else:
                return [apolice_valida]


