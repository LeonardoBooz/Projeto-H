from kivy.app import App
from kivy.uix.boxlayout import BoxLayout
from kivy.uix.label import Label
from kivy.uix.textinput import TextInput
from kivy.uix.button import Button
from kivy.uix.scrollview import ScrollView
import re

class MasterScreen(App):
    def build(self):
        # Layout principal
        self.layout = BoxLayout(orientation='vertical', padding=10, spacing=10)

       
        # Input para texto onde a busca será feita
        self.text_input = TextInput(
            hint_text='Digite o texto aqui', 
            multiline=True,
            foreground_color=(0, 0, 0, 1),  # Cor do texto: preto
            background_color=(1, 1, 1, 1),  # Cor do fundo: branco
            font_size=16  # Tamanho da fonte
        )
        self.layout.add_widget(self.text_input)

        # Layout horizontal para os botões
        button_layout = BoxLayout(orientation='horizontal', size_hint_y=None, height=50, spacing=10)

        # Botão para realizar a busca
        self.search_button = Button(text='Buscar')
        self.search_button.bind(on_press=self.perform_search)
        button_layout.add_widget(self.search_button)

       

if __name__ == '__main__':
    MasterScreen().run()
