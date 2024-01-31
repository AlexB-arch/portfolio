import React from "react";

export default function SearchBox() {
    return (
        <div>
        <input
            type="text"
            name="search"
            id="search"
            placeholder="Search"
            className="p-2 rounded-md border-2 border-gray-300"
        />
        </div>
    );
    }