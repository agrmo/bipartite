from galeshapely.galeshapely import get_pair_map

# python -m galeshapely.main

def main():

    man_preference_map = {
        1: [4,6,5],
        2: [6,4,5],
        3: [4,5,6]
    }
    
    woman_preference_map = {
        4: [2,3,1],
        5: [3,1,2],
        6: [2,3,1]
    }
    
    pair_map = get_pair_map(man_preference_map, woman_preference_map)

    print(pair_map)

if __name__ == "__main__":
    main()
