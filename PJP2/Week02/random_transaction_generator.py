import random
import uuid
# import numpy as np

client_id = ['sape01', 'micr22', 'asus14', 'ibmp02', 'publ31', 'dell15', 'logi81', 'merc16', 'bmwc41', 'tata77']
secret_id = {'sape01': ['901ff604213243d1a90ed73abf82f165', '2291eb6755bb44859a80c8e645a4e88f', '3ffed8385dec4ef3a2d68f6fbd9d3b76', '3b546cce035749078d8ee12ac2a93520'], 'micr22': ['61bc98fda5af4487a8f4669116f2e22c', '7861f9c4e5334983a8f2217ef7169dbe', 'dc69cab0fc8d4c9fa16c0592f36fa563', '681ffe1c1931488f8396cd76efcd4e53'], 'asus14': ['ae72bb54080543f68762b29c47958e8a', '99a9e891e23246ecb155b0539c87b743', 'cfda030a47c4498a92db213d3942ab7c', 'e31b8291f88a4a33adb51d2492be8fbc'], 'ibmp02': ['6021f1ffaac24915af0df90c0be66290', 'c396c9a639c0435d95237f50bf8524e3', 'ae3504c97c514caa9ebcdd0bbf638cbe', '91ce58309b184496a66f351fa9be355a'], 'publ31': ['909307ab4e8b4cf3b358d41bc503a106', '33c75d3905634039ab22ce6bf7c51821', '48250e1b588546b098dea51d733d9b86', 'd1439402c9004b2d867835d38ec23511'], 'dell15': ['38561837c1aa47df92658374fcaf829a', '48af41a73fff4ee3a6078c11e14fb4ed', '95fb5b382c824f51984853718ccfe9a4', '2bde57fd78804bb09abdc2c7083bc7b7'], 'logi81': ['7879d1c834604a01aa2ec43311fffb9d', 'f82027058e8848b8b0f8a431cdd5d13c', '6986d14d9e3a48ab8f6146367f90d2ec', 'f6b8d4cb7a6a40eea7b96f6a9eb5889e'], 'merc16': ['dd23eeee74084d5eb1c6e30ee1fd385e', 'b1d8f176c77245898eba59ff6117049b', '8b6333bb47484463bbe9962c5d670a0e', 'd3bf8d0389734b26b728e406cf375260'], 'bmwc41': ['9092bd30758c4783a6312e8f5bb34fb9', '0fe405896c2043d5afcff380f36c37fe', 'fa1e97cee4b64e8a8a4a9749b68daf26', '4ca41c3a454f4cf7a5027cb5cbab71d5'], 'tata77': ['d42712cbc2e24981a5833add628dcca7', 'ca49bb9d20b64a60a341af4fb12accf5', '6ba8afb0aee7425e9c57fcb67d7fe0dd', '63187b3cb3e845cd8c65b89f64b9d15c']}
date = ['1 2 2020', '2 2 2020', '3 2 2020', '4 2 2020', '5 2 2020', '6 2 2020', '7 2 2020', '8 2 2020', '9 2 2020', '10 2 2020']
type_ = ['buy', 'sell', 'withdraw', 'deposit']
priority = ['yes', 'no', 'no', 'no', 'no', 'no', 'no', 'no', 'no', 'yes', 'no', 'no', 'no', 'no', 'no', 'no', 'no', 'no']

def get_transaction():
    uid = str(uuid.uuid4())
    c_ = random.choice(client_id)
    s_ = random.choice(secret_id[c_])
    d_ = random.choice(date)
    t_ = random.choice(type_)
    p_ = random.choice(priority)
    return uid, c_, s_, d_, t_, p_

def main():
    file_object = open('sample_transaction.txt', 'a')
    for i in range(50000):
        uid, c_, s_, d_, t_, p_ = get_transaction()
        file_object.write(uid+"|"+c_+"|"+s_+"|"+d_+"|"+t_+"|"+p_+"\n")
    file_object.close()
        

if __name__ == "__main__":
    main()
