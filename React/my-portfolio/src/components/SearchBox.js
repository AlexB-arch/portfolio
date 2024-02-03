import React from "react";

export default function SearchBox() {
    return (
		<form className="flex items-center gap-2">
			<input type="search" placeholder="Search" className="px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring focus:ring-blue-400" />
			<button type="submit" className="px-3 py-2 bg-black text-white rounded-md hover:bg-gray-700 focus:outline-none focus:ring focus:ring-black">
				<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth={1.5} stroke="currentColor" className="w-6 h-6">
					<path strokeLinecap="round" strokeLinejoin="round" d="m21 21-5.197-5.197m0 0A7.5 7.5 0 1 0 5.196 5.196a7.5 7.5 0 0 0 10.607 10.607Z" />
				</svg>
			</button>
		</form>
	);
}