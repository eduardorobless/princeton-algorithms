import argparse
import random
import os
parser = argparse.ArgumentParser(description='Create a site file')
parser.add_argument("nodes", help="Enter the number of nodes(sites)", type=int)
parser.add_argument("unions", help="Enter the number of connections(unions)", type=int)
args = parser.parse_args()

base_dir = os.path.dirname(os.path.abspath(__file__)) + "/src"
file_name = 'sites_{}_unions_{}.txt'.format(args.nodes, args.unions)
path = os.path.join(base_dir, file_name)

with open(path, 'w', encoding="utf-8") as f:
    f.write(str(args.nodes) + "\n")
    for i in range(args.unions):
        f.write( str(random.randrange(0, args.nodes, 1)) + " " + str(random.randrange(0, args.nodes, 1)) + "\n")
