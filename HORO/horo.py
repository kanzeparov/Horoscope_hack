from flask import Flask
import numpy as np
from keras.models import load_model
from keras.preprocessing.text import Tokenizer

# generate a sequence from the model
def generate_seq(model, tokenizer, seed_text, n_words):
    in_text, result = seed_text, seed_text
    # generate a fixed number of words
    for _ in range(n_words):
        # encode the text as integer
        encoded = tokenizer.texts_to_sequences([in_text])[0]
        encoded = np.array(encoded)
        # predict a word in the vocabulary
        yhat = model.predict_classes(encoded, verbose=0)
        # map predicted word index to word
        out_word = ''
        for word, index in tokenizer.word_index.items():
            if index == yhat:
                out_word = word
                break
        # append to input
        in_text, result = out_word, result + ' ' + out_word
    return result


app = Flask(__name__)

@app.route('/')
def hello_world():
    return 'Hello World!'

@app.route('/horo/<first_word>')
def horo(first_word = None):
    if not first_word :
        return ""

    with open("data.txt", "r") as f:
        tmp = f.readlines()
    data_for_tok = ""
    for t in tmp :
        data_for_tok += t
            
    tokenizer = Tokenizer()
    tokenizer.fit_on_texts([data_for_tok])
    model_load = load_model('lang_model_tass.h5')
    res = generate_seq(model_load, tokenizer, 'Дева', 20)

    return res


if __name__ == '__main__':
    app.run(host='0.0.0.0', port=80, debug=True)
    app.run()